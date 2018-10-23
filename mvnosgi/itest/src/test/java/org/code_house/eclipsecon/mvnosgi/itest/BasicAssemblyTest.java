package org.code_house.eclipsecon.mvnosgi.itest;

import org.code_house.eclipsecon.mvnosgi.api.BookService;
import org.code_house.eclipsecon.mvnosgi.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.options.MavenArtifactUrlReference;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import javax.inject.Inject;
import java.io.File;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.ops4j.pax.exam.CoreOptions.maven;
import static org.ops4j.pax.exam.karaf.options.KarafDistributionOption.*;

@RunWith(PaxExam.class)
public class BasicAssemblyTest {

    public static final String TITLE = "Quo vadis";
    public static final String AUTHOR = "Henryk Sienkiewicz";

    @Inject
    private BundleContext bundleContext;

    @Inject
    private BookService bookService;

    @Test
    public void testServiceInvocationWithReference() {
        ServiceReference<BookService> reference = bundleContext.getServiceReference(BookService.class);
        BookService service = bundleContext.getService(reference);

        createBook(service);

        bundleContext.ungetService(reference);
    }

    private void createBook(BookService service) {
        UUID id = service.addBook(new Book(null, TITLE, AUTHOR));

        Optional<Book> result = service.find(id);
        assertTrue(result.isPresent());

        Book book = result.get();
        assertEquals(TITLE, book.getTitle());
        assertEquals(AUTHOR, book.getAuthor());
    }

    @Test
    public void testServiceInvocationDirectly() {
        ServiceReference<BookService> reference = bundleContext.getServiceReference(BookService.class);
        BookService service = bundleContext.getService(reference);

        createBook(service);
    }

    @Configuration
    public Option[] createConfiguration() {
        MavenArtifactUrlReference assembly = maven().groupId("org.code-house.eclipsecon.mvnosgi").artifactId("assembly")
            .type("tar.gz")
            .versionAsInProject();
        return new Option[] {
            karafDistributionConfiguration()
                .frameworkUrl(assembly)
                .unpackDirectory(new File("target", "exam"))
                .useDeployFolder(false),
            keepRuntimeFolder(),
            configureConsole().ignoreLocalConsole()
        };
    }


}

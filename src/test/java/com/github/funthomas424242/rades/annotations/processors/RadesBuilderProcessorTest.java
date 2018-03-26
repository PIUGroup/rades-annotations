//TODO Vorbereitung für Unit Test mit compile-testing
package com.github.funthomas424242.rades.annotations.processors;

import com.google.common.truth.Truth;
import com.google.testing.compile.Compilation;
import com.google.testing.compile.JavaFileObjects;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.google.testing.compile.CompilationSubject.assertThat;
import static com.google.testing.compile.Compiler.javac;
import static com.google.testing.compile.JavaSourceSubjectFactory.javaSource;

public class RadesBuilderProcessorTest {

    protected static final String TEST_SRC_FOLDER = "src/test/java/";
    protected static final String TEST_EXPECTATION_FOLDER = "src/test/expectations/";

    protected static URL urlPersonJava;
    protected static URL urlPersonBuilderJava;


    protected static URL getResourceURL(String projectSrcRoot, String resourcePath) throws MalformedURLException {
        final Path tmpPath = Paths.get(projectSrcRoot + resourcePath);
        final URL resourceURL = tmpPath.toAbsolutePath().toUri().toURL();
        System.out.println("Resource:" + resourceURL);
        return resourceURL;
    }

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        urlPersonJava = getResourceURL(TEST_SRC_FOLDER, "com/github/funthomas424242/domain/Person.java");
        urlPersonBuilderJava = getResourceURL(TEST_EXPECTATION_FOLDER, "PersonBuilder.java");
    }


    @Test
    public void processTest() throws MalformedURLException {


        final Compilation compilation = javac()
                .withProcessors(new RadesBuilderProcessor())
                .compile(JavaFileObjects.forResource(urlPersonJava));

        assertThat(compilation).succeeded();
        assertThat(compilation)
                .generatedSourceFile("com.github.funthomas424242.domain.PersonBuilder")
                .hasSourceEquivalentTo(JavaFileObjects.forResource(urlPersonBuilderJava)
                );
    }

    @Test
    public void shouldCompileClassWithoutIgnoreAnnotationWithoutErrors() {

        Truth.assert_().about(javaSource())
                .that(JavaFileObjects.forResource(urlPersonJava))
                .processedWith(new RadesBuilderProcessor())
                .compilesWithoutError();

    }


}
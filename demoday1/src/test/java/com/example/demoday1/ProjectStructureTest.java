package com.example.demoday1;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "com.example.demoday1")
public class ProjectStructureTest {

    @ArchTest
    static final ArchRule layer_dependencies = layeredArchitecture()
            .consideringAllDependencies()
            .layer("Controller").definedBy("..controller..")
            .layer("Service").definedBy("..service..")
            .layer("Repository").definedBy("..repository..")

            // Define allowed dependencies
            .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
            .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
            .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service");

    @ArchTest
    static final ArchRule controller_naming = classes()
            .that().resideInAPackage("..controller..")
            .should().haveSimpleNameEndingWith("Controller")
            .andShould().beAnnotatedWith(RestController.class)
            .andShould().onlyDependOnClassesThat().resideInAnyPackage("java..", "org..", "..service..");

    @ArchTest
    static final ArchRule service_classes = classes()
            .that().resideInAPackage("..service..")
            .should().haveSimpleNameEndingWith("Service")
            .andShould().beAnnotatedWith(Service.class)
            .andShould().onlyDependOnClassesThat().resideInAnyPackage("java..", "org..", "..repository..");


}

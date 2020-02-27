package com.thoughtworks;

import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes("com.thoughtworks.OneArg")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@AutoService(Processor.class)
public class OneArgProcessor extends AbstractProcessor {
  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(OneArg.class);
    for (Element annotatedElement : annotatedElements) {
      if (annotatedElement.getKind() == ElementKind.METHOD) {
        checkForOneParameter((ExecutableElement) annotatedElement);
      }
    }
    return false;
  }

  private void checkForOneParameter(ExecutableElement method) {
   if (method.getParameters().size() != 1) {
     processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,"Only one parameter allowed!", method);
   }
  }

}
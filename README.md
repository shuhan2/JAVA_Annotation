# JAVA_Annotation
Annotation practice which one customized annotation `@OneArg` has been declared.

- `myAnnotation/` contains the `@OneArg` class definition and the corresponding annotation processor; the project was built as `.jar` file in the `target/` folder;
- `OneArgTest`  add `myAnnotation` dependency, use the annotation processor in the `.jar` file, so the `@OneArg` can really work to check if the method only has one parameter. If the method has more than one parameter, an **Error** will be thrown when compiling the `.java` file, and of course the compiling will fail as a result.


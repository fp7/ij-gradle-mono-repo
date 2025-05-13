# Repro parallel model fetching

To reproduce, run `./gradlew :plugin1:dependencies :plugin2:dependencies`
It is a race condition, so it sometimes succeeds. In that case, delete `.intellijPlatform/localPlatformArtifacts` and re-run.

After a few tries it should fail with 

```
Caused by: java.nio.file.FileAlreadyExistsException: /home/finn/dev/projects/reproductions/ij-gradle-mono-repo/.intellijPlatform/localPlatformArtifacts/IC-251.23774.435/bundledPlugin-com.intellij.modules.json-IC-251.23774.435.xml
	at java.base/sun.nio.fs.UnixException.translateToIOException(UnixException.java:94)
	at java.base/sun.nio.fs.UnixException.rethrowAsIOException(UnixException.java:106)
	at java.base/sun.nio.fs.UnixException.rethrowAsIOException(UnixException.java:111)
	at java.base/sun.nio.fs.UnixFileSystemProvider.newByteChannel(UnixFileSystemProvider.java:218)
	at java.base/java.nio.file.Files.newByteChannel(Files.java:380)
	at java.base/java.nio.file.Files.createFile(Files.java:658)
	at org.jetbrains.intellij.platform.gradle.extensions.IntelliJPlatformDependenciesHelper.writeIvyModule(IntelliJPlatformDependenciesHelper.kt:1225)
```

Please ignore the missing classes and wrong plugin descriptors, the errors occurs before.
package cn.maiaimei.samples.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

@Slf4j
public class TempFileSupportTest {

  @TempDir
  File tempDirectory;

  @Test
  public void testTemporaryFolder() throws IOException {
    log.info("{}", tempDirectory.getAbsolutePath());
    assertTrue(Files.isDirectory(tempDirectory.toPath()));
    Path createdFile = Files.createFile(
        tempDirectory.toPath().resolve("createdFile.txt")
    );
    assertTrue(createdFile.toFile().exists());
  }
}

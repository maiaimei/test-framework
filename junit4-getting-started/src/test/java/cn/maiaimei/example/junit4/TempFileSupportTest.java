package cn.maiaimei.example.junit4;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

@Slf4j
public class TempFileSupportTest {

  @Rule
  public TemporaryFolder tempDirectory = new TemporaryFolder();

  @Test
  public void testTemporaryFolder() throws IOException {
    log.info("{}", tempDirectory.getRoot().getAbsolutePath());
    assertTrue(Files.isDirectory(tempDirectory.getRoot().toPath()));
    File createdFile = tempDirectory.newFile("createdFile.txt");
    assertTrue(createdFile.exists());
  }
}

package cn.maiaimei.example.controller;

import cn.maiaimei.example.model.FileInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class FileControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testFileUpload() throws Exception {
    final MockMultipartFile mockMultipartFile = new MockMultipartFile(
        "file",
        "test.txt",
        "text/plain",
        "Hello World".getBytes(StandardCharsets.UTF_8)
    );
    mockMvc.perform(
            MockMvcRequestBuilders.multipart(HttpMethod.POST, "/file/upload").file(mockMultipartFile)
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.jsonPath("$", Matchers.containsString("上传成功-"))
        );
  }

  @Test
  public void testFilesUpload() throws Exception {
    final MockMultipartFile file1 = new MockMultipartFile(
        "files",
        "1.txt",
        "text/plain",
        "Hello World".getBytes(StandardCharsets.UTF_8)
    );
    final MockMultipartFile file2 = new MockMultipartFile(
        "files",
        "2.txt",
        "text/plain",
        "Hello Java".getBytes(StandardCharsets.UTF_8)
    );
    mockMvc.perform(
            MockMvcRequestBuilders.multipart(HttpMethod.POST, "/files/upload")
                .file(file1)
                .file(file2)
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.jsonPath("$", Matchers.containsString("上传成功-"))
        );
  }

  @Test
  public void testFilesSave() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    final MockMultipartFile file = new MockMultipartFile(
        "file",
        "test.txt",
        "text/plain",
        "Hello World".getBytes(StandardCharsets.UTF_8)
    );
    final MockMultipartFile file1 = new MockMultipartFile(
        "files",
        "1.txt",
        "text/plain",
        "Hello World".getBytes(StandardCharsets.UTF_8)
    );
    final MockMultipartFile file2 = new MockMultipartFile(
        "files",
        "2.txt",
        "text/plain",
        "Hello Java".getBytes(StandardCharsets.UTF_8)
    );
    FileInfo fileInfo = new FileInfo();
    fileInfo.setFilename("test.txt");
    mockMvc.perform(
            MockMvcRequestBuilders.multipart(HttpMethod.POST, "/files/save")
                .file(file)
                .file(file1)
                .file(file2)
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .content(objectMapper.writeValueAsString(fileInfo))
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.jsonPath("$", Matchers.containsString("上传成功-"))
        );
  }
}

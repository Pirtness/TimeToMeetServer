package springBootRestService.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springBootRestService.entities.View;
import springBootRestService.repos.FileRepo;
import springBootRestService.entities.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class ImageController {

    //private final Logger logger = LoggerFactory.getLogger(RestUploadController.class);

    //Save the uploaded file to this folder
    private static String UPLOADED__FOLDER = "/Users/Anastasiya/Documents/CourseWork/";

    //3.1.1 Single file upload
    @PostMapping("/api/upload")
    //If not @RestController, uncomment this
    //@ResponseBody
    public ResponseEntity<?> uploadFile(
            @RequestParam("file") MultipartFile uploadfile) {

        //logger.debug("Single file upload!");

        if (uploadfile.isEmpty()) {
            return new ResponseEntity("please select a file!", HttpStatus.OK);
        }

        try {

            saveUploadedFiles(Arrays.asList(uploadfile));

        } catch (IOException e) {
            return null;
        }

        return new ResponseEntity("Successfully uploaded - " +
                uploadfile.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);

    }

    //save file
    private void saveUploadedFiles(List<MultipartFile> files) throws IOException {

        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue;//next pls
            }

            byte[]bytes = file.getBytes();
            Path path = Paths.get(UPLOADED__FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
        }

    }

    @Autowired
    FileRepo fileRepo;

    @PostMapping("api/file/upload")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file) {
        try {
            File fileModel = new File(file.getOriginalFilename(), file.getContentType(), file.getBytes());
            fileRepo.save(fileModel);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @JsonView(View.FileInfo.class)
    @GetMapping("api/file/all")
    public Iterable<File> getListFiles() {
        return fileRepo.findAll();
    }


    @GetMapping("api/file/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        Optional<File> optionalFile = fileRepo.findById(id);
        if (optionalFile.isPresent()){
            File file = optionalFile.get();
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION," ").body(file.getPic());
        }
        //return ResponseEntity.status(404).body(null);
        return null;
    }

}

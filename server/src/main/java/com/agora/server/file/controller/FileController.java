package com.agora.server.file.controller;

import com.agora.server.common.dto.ResponseDTO;
import com.agora.server.file.dto.FileDto;
import com.agora.server.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("api/v2/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping(value = "save", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<ResponseDTO> addFile(@RequestParam("files") MultipartFile[] files){
        ArrayList<MultipartFile> allfile = new ArrayList<>();
        for(int i=0; i<files.length; i++){
            allfile.add(files[i]);
        }

        List<FileDto> fileDtos = fileService.uploadFiles(allfile);
        ResponseDTO responseDTO = new ResponseDTO();
        if(fileDtos!=null){
            responseDTO.setState(true);
            responseDTO.setStatusCode(200);
            responseDTO.setMessage("파일 정상 업로드 완료");
            responseDTO.setBody(fileDtos);
        }else{
            responseDTO.setState(false);
            responseDTO.setMessage("파일 업로드 실패");
        }

        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteFile(@RequestBody Map<String, List<String>> items) throws IOException {
        fileService.deleteFile(items.get("files"));
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setState(true);
        responseDTO.setStatusCode(200);
        responseDTO.setMessage("정상 삭제 완료");
        return ResponseEntity.ok(responseDTO);
    }
}

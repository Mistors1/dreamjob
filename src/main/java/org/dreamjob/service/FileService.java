package org.dreamjob.service;

import org.dreamjob.dto.FileDto;
import org.dreamjob.model.File;

import java.util.Optional;

public interface FileService {

    File save(FileDto fileDto);

    Optional<FileDto> getFileById(int id);

    boolean deleteById(int id);

}

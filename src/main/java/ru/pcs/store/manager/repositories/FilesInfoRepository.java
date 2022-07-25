package ru.pcs.store.manager.repositories;

import ru.pcs.store.manager.model.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesInfoRepository extends JpaRepository<FileInfo, Long> {
    FileInfo findByStorageName(String storageName);
}

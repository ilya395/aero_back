package ru.pcs.store.manager.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class FileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String originalName;

    private String storageName;

    private String mimeType;

    private Long size;

    private LocalDateTime uploadDateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileInfo fileInfo = (FileInfo) o;
        return Objects.equals(id, fileInfo.id)
                && Objects.equals(description, fileInfo.description)
                && Objects.equals(originalName, fileInfo.originalName)
                && Objects.equals(storageName, fileInfo.storageName)
                && Objects.equals(mimeType, fileInfo.mimeType)
                && Objects.equals(size, fileInfo.size)
                && Objects.equals(uploadDateTime, fileInfo.uploadDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, originalName, storageName, mimeType, size, uploadDateTime);
    }
}

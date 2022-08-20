package uz.pd.click_full.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pd.click_full.entity.Attachment;


import java.util.UUID;

public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
}

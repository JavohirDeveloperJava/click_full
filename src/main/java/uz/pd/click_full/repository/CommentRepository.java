package uz.pd.click_full.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pd.click_full.entity.Comment;


import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
}

package training.webblog.dashboard;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "article")
@Getter
@Setter
public class ArticleEntity {

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;
    private String content;
    private String author;

}

package training.webblog.dashboard;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class WebBlogDashboardServiceApplication {

    private final ArticleRepository articleRepository;

    public WebBlogDashboardServiceApplication(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebBlogDashboardServiceApplication.class, args);
    }

    @PostConstruct
    private void init() {

        String[] users = {"light.blogger", "heavy.blogger", "creative.blogger"};

        for (int i = 0; i < 10; i++) {
            ArticleEntity articleEntity = new ArticleEntity();
            articleEntity.setTitle(UUID.randomUUID().toString().substring(0, 8));
            articleEntity.setContent(UUID.randomUUID().toString());
            articleEntity.setAuthor(users[new Random().nextInt(users.length)]);
            articleRepository.save(articleEntity);
        }
    }

}

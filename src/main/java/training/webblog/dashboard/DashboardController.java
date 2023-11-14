package training.webblog.dashboard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DashboardController {

    private final ArticleService articleService;

    public DashboardController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles")
    public ResponseEntity<GetArticlesResponseBody> getArticles() {

        List<ArticleDto> articleDtos = articleService.listAllArticles();
        GetArticlesResponseBody getArticlesResponseBody = new GetArticlesResponseBody();
        getArticlesResponseBody.setArticles(articleDtos);

        return ResponseEntity.ok().body(getArticlesResponseBody);
    }

}

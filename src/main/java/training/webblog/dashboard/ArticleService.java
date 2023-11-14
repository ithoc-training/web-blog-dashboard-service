package training.webblog.dashboard;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<ArticleDto> listAllArticles() {

        List<ArticleEntity> allArticles = articleRepository.findAll();

        return allArticles.stream().map(articleEntity -> {
            ArticleDto articleDto = new ArticleDto();
            articleDto.setTitle(articleEntity.getTitle());
            articleDto.setContent(articleEntity.getContent());
            articleDto.setAuthor(articleEntity.getAuthor());
            return articleDto;
        }).toList();
    }

}

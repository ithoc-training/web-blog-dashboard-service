package training.webblog.dashboard;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetArticlesResponseBody {

    private List<ArticleDto> articles;

}

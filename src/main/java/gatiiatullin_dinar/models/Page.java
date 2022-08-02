package gatiiatullin_dinar.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@Entity
//@Table(name = "page", indexes = {@javax.persistence.Index(columnList = "path", name = "path_index")})
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "path")
    private String path;

    @Column(name = "code")
    private Integer code;

    @Column(name = "content", length = 100000)
    private String content;

    public Page(String path, Integer code, String content) {
        this.path = path;
        this.code = code;
        this.content = content;
    }

    public Page() {
    }

    public void setContent(String content) {
        this.content = content == null ? "" : content.replaceAll("\\s*\\n\\s*", "");
    }
}
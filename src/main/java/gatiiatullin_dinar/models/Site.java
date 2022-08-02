package gatiiatullin_dinar.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "site")
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private StatusType status;

    @Column(name = "status_time",nullable = false)
    private Long statusTime;

    @Column(name = "last_error",nullable = false)
    private String lastError;

    @Column(name = "url",nullable = false)
    private String url;

    public Site(Integer id, StatusType status, Long statusTime, String lastError, String url, String name) {
        this.id = id;
        this.status = status;
        this.statusTime = statusTime;
        this.lastError = lastError;
        this.url = url;
        this.name = name;
    }

    @Column(name = "name",nullable = false)
    private String name;
}

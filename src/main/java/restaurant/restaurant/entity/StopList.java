package restaurant.restaurant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "stop_lists")
public class StopList {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stop_list_gen")
    @SequenceGenerator(name = "stop_list_gen",
            sequenceName = "stop_list_seq",
            allocationSize = 1)
    private Long id;
    private String reason;
    private LocalDate date;

    @OneToOne(mappedBy = "stopList", cascade = CascadeType.ALL)
    private MenuItem menuItem;
}

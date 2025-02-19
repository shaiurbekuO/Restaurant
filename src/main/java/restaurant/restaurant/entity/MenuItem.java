package restaurant.restaurant.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "menu_items")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_item_gen")
    @SequenceGenerator(name = "menu_item_gen",
            sequenceName = "menu_item_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private String image;
    private BigDecimal price;
    private String description;
    private boolean isVegetarian;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Restaurant restaurant;

    @ManyToMany(mappedBy = "menuItems", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Cheque> cheques;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Subcategory subcategory;

    @OneToOne(cascade = CascadeType.ALL)
    private StopList stopList;
}

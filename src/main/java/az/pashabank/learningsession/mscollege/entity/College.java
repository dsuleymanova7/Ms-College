package az.pashabank.learningsession.mscollege.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class College {
    private Integer id;
    private String name;
    private String city;
}


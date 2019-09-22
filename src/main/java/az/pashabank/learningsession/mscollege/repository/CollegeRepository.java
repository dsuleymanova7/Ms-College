package az.pashabank.learningsession.mscollege.repository;

import az.pashabank.learningsession.mscollege.entity.College;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
public class CollegeRepository {

    private List<College> colleges;

    public CollegeRepository() {
        colleges = new ArrayList<>() {
            {
                add(new College(1, "BEU", "Khirdalan"));
                add(new College(2, "ADNSU", "Baku"));
                add(new College(3, "MGU", "Moscow"));
            }
        };
    }
}
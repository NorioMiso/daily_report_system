package actions.views;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LikeView {

    private Integer id;
    private Integer employeeId;
    private Integer reportId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer likedFlag;
}

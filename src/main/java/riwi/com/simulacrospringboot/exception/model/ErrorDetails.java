package riwi.com.simulacrospringboot.exception.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorDetails {
    private String attributeName;
    private String reason;


}

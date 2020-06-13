package org.screen.entity.status;

import com.haulmont.chile.core.datatypes.impl.EnumClass;
import org.springframework.lang.Nullable;

public enum Season implements EnumClass<Integer> {
    SUMMER(1),
    WINTER(2),
    SPRING(3),
    AUTUMN(4);

    private Integer id;

    Season(Integer id) {
        this.id = id;

    }
    @Nullable
    public static Season fromId(Integer id) {
        Season result = null;
        for (Season status : Season.values()) {
            if (status.getId().equals(id))
                result = status;
        }
        return result;
    }

    @Override
    public Integer getId() {
        return id;
    }
}

package org.screen.entity.status;

import com.haulmont.chile.core.datatypes.impl.EnumClass;
import jdk.internal.jline.internal.Nullable;

public enum MessagesStatus implements EnumClass<Integer> {
       CREATE(0),
       SUCCES(1),
       ERROR(-1);

       private final int id;

       MessagesStatus(Integer id) {
              this.id = id;
       }

       @Override
       public Integer getId() {
              return id;
       }
       @Nullable
       public static MessagesStatus fromId(Integer id) {
              MessagesStatus result = MessagesStatus.CREATE;
              for (MessagesStatus status : MessagesStatus.values()) {
                     if (status.getId().equals(id))
                            result = status;
              }
              return result;
       }
}

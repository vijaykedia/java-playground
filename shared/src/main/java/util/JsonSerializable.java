package util;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import java.io.Serializable;

/**
 * This interface defines a default method {@link #toJson()} for converting an implementing object's
 * state into a JSON-formatted string using a specific serialization feature for pretty formatting.
 */
public interface JsonSerializable extends Serializable {

  default String toJson() {
    return JSON.toJSONString(
        this, JSONWriter.Feature.PrettyFormatWith2Space, JSONWriter.Feature.FieldBased);
  }
}

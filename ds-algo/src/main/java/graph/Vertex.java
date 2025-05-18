package graph;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a graph vertex, containing data and a list of connected edges. A vertex can connect to
 * other vertices by adding edges, either with or without a specified weight.
 *
 * @param <T> the type of data contained in the vertex. Must implement {@code Comparable}.
 * @param <W> the type of weight associated with the edges. Can be null for unweighted edges.
 */
@Getter
public class Vertex<T extends Comparable<? super T>, W> {

  private final T data;

  private final List<Edge<T, W>> edges;

  public Vertex(@NotNull final T data) {
    this.data = data;
    this.edges = new ArrayList<>();
  }

  public void addEdge(@NotNull final Vertex<T, W> to, @Nullable final W weight) {
    this.edges.add(new Edge<T, W>(this, to, weight));
  }

  public void addEdge(@NotNull final Vertex<T, W> to) {
    this.edges.add(new Edge<T, W>(this, to));
  }

  public void removeEdge(@NotNull final Vertex<T, W> to) {
    this.edges.removeIf(edge -> edge.getTo().equals(to));
  }

  @Override
  public boolean equals(@Nullable final Object o) {
    if (o == null || getClass() != o.getClass()) return false;

    // noinspection unchecked
    Vertex<? extends T, ?> vertex = (Vertex<? extends T, ?>) o;
    return getData().compareTo(vertex.getData()) == 0;
  }

  @Override
  public int hashCode() {
    int result = getData().hashCode();
    result = 31 * result + getEdges().hashCode();
    return result;
  }
}

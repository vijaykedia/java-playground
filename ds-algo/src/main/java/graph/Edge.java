package graph;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents an edge in a graph, connecting two vertices and optionally carrying a weight.
 *
 * @param <T> the type of the data contained in the vertices. Must implement {@code Comparable}.
 * @param <W> the type of the weight associated with the edge. Can be null for unweighted edges.
 */
@Getter
public class Edge<T extends Comparable<? super T>, W> {

  private final Vertex<T, W> from;

  private final Vertex<T, W> to;

  private final W weight;

  public Edge(@NotNull final Vertex<T, W> from, @NotNull final Vertex<T, W> to) {
    this(from, to, null);
  }

  public Edge(
      @NotNull final Vertex<T, W> from, @NotNull final Vertex<T, W> to, @Nullable final W weight) {
    this.from = from;
    this.to = to;
    this.weight = weight;
  }
}

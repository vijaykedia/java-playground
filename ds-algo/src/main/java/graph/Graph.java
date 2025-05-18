package graph;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
public class Graph<T extends Comparable<? super T>, W> {

  private final Set<Vertex<T, W>> vertices;

  private final boolean directed;

  private final boolean weighted;

  public Graph() {
    this(false, false);
  }

  public Graph(final boolean directed, final boolean weighted) {
    this.vertices = new HashSet<>();
    this.directed = directed;
    this.weighted = weighted;
  }

  public void addToGraph(@NotNull final T data) {
    this.vertices.add(new Vertex<>(data));
  }

  public void removeFromGraph(@NotNull final T data) {
    this.vertices.removeIf(vertex -> vertex.getData().compareTo(data) == 0);
  }

  public void addVertex(@NotNull final Vertex<T, W> vertex) {
    this.vertices.add(vertex);
  }

  public void removeVertex(@NotNull final Vertex<T, W> vertex) {
    this.vertices.remove(vertex);
  }

  public void addEdge(@NotNull final Vertex<T, W> from, @NotNull final Vertex<T, W> to) {
    if (this.weighted) {
      throw new UnsupportedOperationException(
          "Weighted graph does not support unweighted edges, Please use addEdge(from, to, weight)");
    }
    this.vertices.add(from);
    this.vertices.add(to);
    if (this.directed) {
      from.addEdge(to);
    } else {
      from.addEdge(to);
      to.addEdge(from);
    }
  }

  public void addEdge(
      @NotNull final Vertex<T, W> from, @NotNull final Vertex<T, W> to, @Nullable final W weight) {
    final W finalWeight = this.weighted ? weight : null;
    this.vertices.add(from);
    this.vertices.add(to);
    if (this.directed) {
      from.addEdge(to, finalWeight);
    } else {
      from.addEdge(to, finalWeight);
      to.addEdge(from, finalWeight);
    }
  }
}

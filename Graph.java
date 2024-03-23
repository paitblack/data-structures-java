public class Graph<T extends Comparable> {
    Vertex<T> head;

    public Vertex<T> findVertex(T id){
        Vertex<T> iterator=head;
        while(iterator!=null){
            if(iterator.id.compareTo(id)==0){
                return iterator;
            }
            iterator=iterator.nextVertex;
        }
        return null;

    }
    public void addVertex(T id){
        if(findVertex(id)!=null)
        {
            System.out.println("IT ALREADY EXISTS");
            return;
        }
        Vertex<T> newVertex= new Vertex<>(id);
        if (head==null)
            head=newVertex;
        else{
            Vertex<T> iterator=head;
            while(iterator.nextVertex!=null)
                iterator=iterator.nextVertex;
            iterator.nextVertex=newVertex;
        }
    }
    public void addEdge(T startingId, T endId, int w){
        Vertex<T> current=findVertex(startingId);
        Edge<T> newEdge=new Edge<>(endId, w);
        Edge<T> iteratorEdge=current.edgeLink;
        if(iteratorEdge==null)
            current.edgeLink=newEdge;
        else{
            while(iteratorEdge.nextEdge!=null)
                iteratorEdge=iteratorEdge.nextEdge;
            iteratorEdge.nextEdge=newEdge;
        }
    }
    public int outDegree(T id){
        Vertex<T> current=findVertex(id);
        int count=0;
        Edge<T> iteratorEdge=current.edgeLink;
        while(iteratorEdge!=null)
        {
            iteratorEdge=iteratorEdge.nextEdge;
            count++;

        }
        return count;
    }
    public void display(){
        Vertex<T> iteratorVertex=head;
        while(iteratorVertex!=null){
            System.out.print(iteratorVertex.id+"->");
            Edge<T> iteratorEdge=iteratorVertex.edgeLink;
            while(iteratorEdge!=null){
                System.out.print(iteratorEdge.vertexId+" ");
                iteratorEdge=iteratorEdge.nextEdge;
            }
            System.out.println();
            iteratorVertex=iteratorVertex.nextVertex;
        }
    }
    public boolean checkPath(T first, T second){
        Vertex<T> current = findVertex(first);
        Edge<T> iterator = current.edgeLink;
        int result = 0;
        while(iterator != null){
            if (iterator.vertexId.compareTo(second)==0){
                result++;
            }
            iterator = iterator.nextEdge;
        }
        Vertex<T> current2 = findVertex(second);
        Edge<T> iterator2 = current2.edgeLink;
        while(iterator2 != null){
            if (iterator2.vertexId.compareTo(first)==0){
                result++;
            }
            iterator2 = iterator2.nextEdge;
        }
        return result == 2;
    }
    public void displayAdjacents(T id){
        Vertex<T> current = findVertex(id);
        Edge<T> edgeLink = current.edgeLink;
        while(edgeLink != null){
            System.out.println(edgeLink.vertexId);
            edgeLink = edgeLink.nextEdge;
        }
    }
}
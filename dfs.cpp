//graph
#include <iostream>
#include <list>
#include <vector>
using namespace std;
class Graph
{
	int v;
	list<int> *adj;
	void dfsUtil(int v, bool visited[]);

	public:
	Graph(int v);
	void addEdge(int a, int b);
	void dfs(int v);
};

Graph :: Graph(int v)
{
	this->v = v;
	adj = new list<int> [v];
}

void Graph :: addEdge(int a, int b)
{
	adj[a].push_back(b);
	adj[b].push_back(a);
}

void Graph :: dfsUtil(int v, bool visited[])
{
	visited[v] = true;
	cout << v <<" ";
	list<int> :: iterator i;
	for(i=adj[v].begin(); i!=adj[v].end(); i++)
		if(!visited[*i])
			dfsUtil(*i, visited);
}

void Graph :: dfs(int s)
{
	bool visited[v] = {false};
	dfsUtil(s,visited);
}

int main()
{
	int v;
	cin >> v;
	Graph g(5);
	g.addEdge(0,1);
	g.addEdge(0,4);
	g.addEdge(1,4);
	//g.addEdge(1,2);
	//g.addEdge(4,2);
	g.addEdge(2,3);
	g.dfs(2);
	return 0;
}

package it.polito.tdp.PremierLeague.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.PremierLeague.db.PremierLeagueDAO;

public class Model {
	
	private PremierLeagueDAO dao;
	private Graph<Match, DefaultWeightedEdge> grafo;
	
	public Model() {
		
		this.dao = new PremierLeagueDAO();
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		
	}
	public List<Match> getVertex(Integer mese){
		return this.dao.getVertex(mese);
	}

	public Graph<Match, DefaultWeightedEdge> creaGrafo(Integer mese, Integer minuti){
		
		Graphs.addAllVertices(this.grafo, getVertex(mese));
		
		for(Match m1 : this.grafo.vertexSet()) {
			for(Match m2 : this.grafo.vertexSet()) {
				
				List<Integer> trovati = new ArrayList<>();
				
				List<Integer> pl1 = this.dao.getPlayer(m1, minuti);
				List<Integer> pl2 = this.dao.getPlayer(m2, minuti);
				
				
				if(m1.getMatchID()!=m2.getMatchID()) {
					
					for(Integer id1 : pl1) {
						if(pl2.contains(id1)) {
							trovati.add(id1);
						}
					}
					
					if(trovati.size()!=0) {
					
						Graphs.addEdge(this.grafo, m1, m2, trovati.size());
					}
					
				}
				
				
				
			}
		}
		
		return grafo;
	}
	
	
	public List<DefaultWeightedEdge> getMax() {
			
			List<DefaultWeightedEdge> archi = new ArrayList<>();
			
			int max = 0;
			
			for(DefaultWeightedEdge p : this.grafo.edgeSet()) {
				if(this.grafo.getEdgeWeight(p) > max) {
					max = (int)this.grafo.getEdgeWeight(p);
					
				}
			}
			
			for(DefaultWeightedEdge i : this.grafo.edgeSet()) {
				if(this.grafo.getEdgeWeight(i)==max) {
					archi.add(i);
				}
			}
			
			return archi;
		}
}

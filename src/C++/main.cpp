#include <iostream>
#include <vector>
#include "Perceptron.cpp"

int main(int argc, char** argv) {
	
	Perceptron *p = new Perceptron();
	
	//converte um array 2d para um vector bidimensional
	int auxEntrie[4][2] = { {0,0}, {0,1}, {1,0}, {1,1} };
	std::vector< std::vector<int> > myentries;
	
	for( int i =0; i<4; i++ ){
		std::vector<int> aux;
		
		for( int j = 0; j < 2; j++ ){
			aux.push_back( auxEntrie[i][j] );	
		}
		
		myentries.push_back( aux );
	}
	
	int auxSupervisor[] = {0,0,0,1};
	std::vector<int> mysupervisor;
	for( int k = 0; k < 4; k++ ){
		mysupervisor.push_back( auxSupervisor[k] );
	}
	
	p->set_entries( myentries );
	p->set_supervisor( mysupervisor ); 
	p->train();
	
	delete p;

	return 0;
}

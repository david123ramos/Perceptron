#include <iostream>
#include <vector>
#include <cmath>


class Perceptron{
	
	private:
		
		std::vector< std::vector<int> > entries;
		std::vector<int> supervisor;
		std::vector<double> weights;
		double lr;
		
		
	public: 
		Perceptron(){
			
			this->lr = 0.1;
			
			for(int i =0; i < 2; i++){
				this->weights.push_back(0.0);
			}
		}
		
		void set_entries(std::vector< std::vector<int> > ent){
			this->entries = ent;
		}
		
		void set_weights(std::vector<double> weig){
			this->weights = weig;
		}
		
		void set_supervisor( std::vector<int> s){
			this->supervisor = s;
		}
		
		void set_lr(double lr){
			this->lr = lr;
		}
				int stepFunction(double value){
			return value >= 1 ? 1 : 0;
		}
		
		double calculateNewValue( double prevValue, int errorRate, int posX, int posY ){
			return prevValue + ( this->lr * this->entries[posX][posY] * errorRate );
		}
		
		int classify( std::vector<int> value ){
			
			double sum=0;
			
			for( int i=0; i<value.size(); i++ ){
				sum += this->weights[i] * value[i];
			}
			return this->stepFunction(sum);
		}
		
		
		void train(){
			
			int totalError = 1;
			
			while( totalError != 0 ){
				
				totalError = 0;
				
				for(int i =0; i < this->supervisor.size(); i++){
					
					int resp = this->classify( this->entries[i] );
					
					int error = abs( this->supervisor[i] - resp );
					
					totalError += error;
					
					for( int j = 0; j < this->weights.size(); j++ ){
						double prev = this->weights[j];
						this->weights[j] = this->calculateNewValue(prev, error, i, j);
						
						std::cout << "Pesos atualizados " << this->weights[j] << std::endl;
					}
					std::cout << "Total de erros " << totalError << std::endl;
				}
			}
		}
};

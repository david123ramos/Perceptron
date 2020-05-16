import numpy as np

def stepFunction(value):
    return 1 if value >= 1 else 0

class Perceptron:
    
    def set_entries(self, entries):
        self.entries = np.array(entries)
    
    def set_supervisor(self, supervisor):
        self.supervisor = np.array(supervisor)
    
    def set_weight(self, weight):
        self.weight = np.array(weight)
    
    def set_lr(self, lr=0.1):
        self.lr = lr
    
    def set_ac_function(self, acf):
        self.acf = acf

    def clasify(self, value):
        s = value.dot(self.weight)
        print("------> ", self.weight, value, s)
        return self.acf( s )

    def train(self):
        totalError = 1

        while(totalError != 0):
            totalError = 0
            
            for i in range( len( self.supervisor ) ):
                resp = self.clasify( np.asarray( self.entries[i] ))
                
                error =  abs( self.supervisor[i] - resp )
                
                totalError = totalError + error

                print( totalError, "######" )
                
                for j in range( len( self.weight ) ):
                    
                    self.weight[j] = self.weight[j] + (self.lr * self.entries[i][j] * error)
                    
                    print( "Peso atualizado "+str( self.weight[j] ) )
                print( "Total de erro "+str( totalError ) )



if __name__ == "__main__":
    
    entries = np.array( [ [ 0,0 ],[ 0,1 ],[ 1,0 ],[ 1,1 ]  ])
    supervisor = np.array( [ 0, 0, 0 , 1 ] )
    weight = np.array( [0.0, 0.0] )

    p = Perceptron()
    p.set_entries(entries)
    p.set_supervisor(supervisor)
    p.set_weight(weight)
    p.set_ac_function(stepFunction)
    p.set_lr(0.1)

    p.train()
        

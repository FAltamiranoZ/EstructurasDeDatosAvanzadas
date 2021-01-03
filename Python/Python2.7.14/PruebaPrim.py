class minHeap:
    datos = [""]
    cont = 0
    def _init_(self):
        self.datos = [""]
        self.cont = 0

    def borra(self):
        self.datos = [""]
        self.cont = 0
    def inserta(self, e):
        self.cont+=1
        self.datos.insert(self.cont, e)
        actual = self.cont
        while(actual>1):
            if(self.datos[actual] < self.datos[actual >> 1]):
                temp = self.datos[actual]
                self.datos[actual] = self.datos[actual >> 1]
                self.datos[actual >> 1] = temp
                actual = actual >> 1
            else:
                break
    def borraMin(self):
        if(self.cont > 1):
            temp = self.datos[1]
            self.datos[1] = self.datos[self.cont]
            del self.datos[self.cont]
            self.cont-=1
            if(self.cont>2):
                self.bubble(1)
            return temp
        elif(self.cont==1):
            self.cont=0
            temp = self.datos[1]
            self.datos = [""]
            return temp
        else:
            print("Arbol vacio")
    def buscaMin(self):
        if(not self.cont == 0):
            return self.datos[1]
    def toString(self):
        print(self.datos[1:])
    def bubble(self,  i):
        if(self.cont>2):
            actual=self.datos[i]
            if(i<self.cont+1):
                if((i*2)<self.cont and ((i*2)+1)<=self.cont):
                    if (actual < self.datos[i * 2] and actual > self.datos[(i * 2) + 1]):
                        aux = actual
                        self.datos[i] = self.datos[(i * 2) + 1]
                        self.datos[(i * 2) + 1] = aux
                        pos = (i * 2) + 1
                    elif (actual > self.datos[i * 2] and actual < self.datos[(i * 2) + 1]):
                        aux = actual
                        self.datos[i] = self.datos[(i * 2)]
                        self.datos[(i * 2)] = aux
                        pos = i * 2
                    elif (actual > self.datos[i * 2] and actual > self.datos[(i * 2) + 1]):
                        aux = actual
                        self.datos[i] = self.datos[(i * 2)]
                        self.datos[(i * 2)] = aux
                        self.bubble(i)
                        pos = i * 2
                    else:
                        return
                    self.bubble(pos)
                elif ((i*2)<self.cont and ((i*2)+1)>self.cont):
                    if(actual>self.datos[i*2]):
                        aux = actual
                        self.datos[i] = self.datos[(i * 2)]
                        self.datos[(i * 2)] = aux
                        pos = (i * 2)
                    self.bubble(pos)
                else:
                    return
            else:
                return
        else:
            if(self.datos[1]>self.datos[2]):
                aux=self.datos[2]
                self.datos[2]=self.datos[1]
                self.datos[1]=aux

def prim(graph):
        root = graph[0][0]
        min_spanning_tree = list()
        used_nodes = set(root[0][0])
        free_nodes = set()
        for i in range(18):
            free_nodes.add(graph[i][0])
            free_nodes.add(graph[i][1])
        free_nodes.remove(root)
        edges = minHeap()
        while len(free_nodes) > 0:
            aux = list()
            for i in range(18):
                if (used_nodes.__contains__(graph[i][0]) and not used_nodes.__contains__(graph[i][1])) or (not used_nodes.__contains__(graph[i][0]) and used_nodes.__contains__(graph[i][1])):
                    aux.append(graph[i])
                    edges.inserta(graph[i][2])
            min_edge = edges.borraMin()
            cond = False
            ruta = graph[i]
            i = 0
            while i<len(aux) and cond == False:
                if min_edge == aux[i][2]:
                    cond=True
                    ruta = [aux[i][0],aux[i][1],aux[i][2]]
                i=i+1
            if  used_nodes.__contains__(ruta[0]) and not used_nodes.__contains__(ruta[1]):
                used_nodes.add(ruta[1])
                hijo = ruta[1]
                papa = ruta[0]
            else:
                used_nodes.add(ruta[0])
                hijo = ruta[0]
                papa = ruta[1]
            min_spanning_tree.append([papa, hijo, min_edge])
            free_nodes.discard(hijo)
            print ('min_edge: %s' % str(min_edge))
            print ('used_nodes: %s' % str(used_nodes))
            print ('min_spanning_tree(%i): %s' % (len(min_spanning_tree), str(min_spanning_tree)))
            edges.borra()
            print('------------------------')

graphi=[['a','b',27],['a','c',23],['b','c',13],['b','d',38],['c','e',26],['c','f',25],['d','e',24],['d','g',25],['d','j',48],['e','f',20],['e','g',30],['e','h',26],['f','i',42],['f','h',25],['g','h',31],['g','k',37],['g','j',29],['h','k',32]]

prueba=prim(graphi)
print (prueba)
class minHeap:
    datos = [-1]
    cont = 1

    def inserta(self, elem):
        self.datos.append(elem)
        actual = self.cont
        while(self.datos[actual]<self.datos[self.cont/2]):
            temp=self.datos[actual]
            self.datos[actual]=self.datos[actual>>1]
            self.datos[actual>>1]=temp
            actual=actual>>1
        self.cont+=1

    def buscaMin(self):
        print self.datos[1]

    def borraMin(self):
        if(self.cont!=0):
            temp=self.datos[1]
            i=1
            self.datos[1]=self.datos[(self.cont-1)]
            self.cont-=1
            print self.cont
            termine=False
            while termine!=True:
                if(not(i>=(self.cont/2) and i<=self.cont)):
                    if (self.datos[i] > self.datos[i * 2] or self.datos[i] > self.datos[i * 2 + 1]):
                        if (self.datos[i * 2] < self.datos[i * 2 + 1]):
                            aux = self.datos[1 * 2]
                            self.datos[i * 2] = self.datos[i]
                            self.datos[i] = aux
                            i = i * 2
                        else:
                            aux = self.datos[i * 2 + 1]
                            self.datos[i * 2 + 1] = self.datos[i]
                            self.datos[i] = aux
                            i = i * 2 + 1
                    else:
                        termine=True
                else:
                    termine=True
            print self.datos[self.cont]
            self.datos.pop(self.cont)
        else:
            print 'El arreglo esta vacio'

    def toString(self):
        self.datos.pop(0)
        print self.datos
        self.datos.insert(0, -1)


a = minHeap()
a.inserta(978)
a.inserta(2)
a.inserta(1)
a.inserta(65)
a.inserta(12)
a.inserta(54)
a.inserta(32)
a.toString()
a.borraMin()
a.toString()
a.borraMin()
a.toString()
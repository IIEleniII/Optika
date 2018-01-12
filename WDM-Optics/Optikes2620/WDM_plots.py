import numpy as np
import matplotlib.pyplot as plt
from decimal import Decimal
#
# throughput
with open('throughput.py') as f:
    throughput = f.readlines()
# remove \n and ''
throughput = [x.strip() for x in throughput]
throughput = [float(i) for i in throughput]

with open('probability.py') as f:
    prob = f.readlines()
# remove \n and ''
prob = [x.strip() for x in prob]
prob = [float(i) for i in prob]

#average delay
with open('AvgDelay.py') as f:
    delay = f.readlines()
# remove \n and ''
delay  = [x.strip() for x in delay ]
delay  = [float(i) for i in delay ]

with open('probability.py') as f:
    prob = f.readlines()
# remove \n and ''
prob = [x.strip() for x in prob]
prob = [float(i) for i in prob]

#Plot reults
plt.subplot(2, 1, 1)
plt.plot(throughput, prob, 'o')
plt.axis([0,1.0 , 0, 1.0])
plt.title('PLOTS')
plt.ylabel('probability')
plt.xlabel('Throughput')

plt.subplot(2, 1, 2)
plt.plot(delay , prob, 'o')
plt.axis([0,30000 , 0.0, 1.0])
plt.xlabel('AvgDelay(ns)')
plt.ylabel('probability')

plt.show()

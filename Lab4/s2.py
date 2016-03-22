# read file
import sys
f = sys.stdin
f = open(sys.argv[1], "r")
l = f.readline()

while l :
	l = l.strip( '\t\n' )
	i = 0
	total = 0
	
	# calculates average for each line
	for w in l.split(',') :
		if i>0:
			total += int(w)
		else :
			name = w
		i += 1
	
	
	average = total / (i-1)
	print name, average
	l = f.readline()

f.close()

# read file
import sys
f = sys.stdin
f = open(sys.argv[1], "r")
l = f.readline()

# initialize dictionary
mydict = {}

# sets id and name for each line in file
while l :
	l = l.strip( '\t\n' )
	i = 0
	name = ""
	for w in l.split() :
		if i > 0 :
			name = name + w + " "
		else :
			id = int(w)
		i += 1

# builds dictionary using the parsed values
	mydict[id] = name
	l = f.readline()
sortedDict = sorted(mydict.keys())
for key in sortedDict:
	print  (key, mydict[key])
f.close()

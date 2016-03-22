#!/usr/bin/python

# opens user-provided file, or uses sample.in as the default if one is not
# provided
import sys
if len( sys.argv ) < 2 :
	fileName = "sample.in"
else :
	fileName = sys.argv[1]
file = open(fileName, "r")

wholeTable = {}					# stores all data, keys are team names
teamList = []						# the initial list, of just team names

# reads data from file, creating a local list to make writing to wholeTable
# easier.  At the end of this block, wholeTable is filled with all data and
# team List is filled with all team names
for i in file :
	i = i.strip()
	fieldCount = 0
	localList = []
	for field in i.split(",") :
		if (fieldCount == 2) :
			key = field
			if not (wholeTable.has_key(key)) :
				wholeTable[key] = key
				wholeTable[key] = []
				teamList.append(key)
		else :		
			localList.append(field)
		fieldCount += 1
	wholeTable[key].append(localList)

# sorts the teamList and displays it with numbered options
teamList.sort()
again = True		# boolean controls the continual looping of menu code until
							# the quit option is selected
while again :
	numberer = 1
	print "\n"
	for i in teamList :
		print numberer, i
		numberer += 1

	print "\n99 Quit"

	# user enters team number, causing the program to look up that team in
	# the wholeTable.  The players with that key are then listed out.  Two
	# new playerLists are maintained, one to hold just the last name for
	# further lookup, and one to hold first and last name for output purposes
	selectedTeamNum = int(raw_input( "\nEnter the number of the team you want: "
))

	if (selectedTeamNum == 99) :
		again = False
		sys.exit
	else :
		selectedTeamName = teamList[selectedTeamNum-1]
		print selectedTeamName, "\n"

		playerList = []
		printPlayerList = []
		teamLength = len(wholeTable[selectedTeamName])
		for i in range(teamLength) :
			player = wholeTable[selectedTeamName] [i] [0]
			printPlayer = (wholeTable[selectedTeamName] [i] [1] + " " +
		wholeTable[selectedTeamName] [i] [0])
			playerList.append(player)
			printPlayerList.append(printPlayer)
		playersLength = len(playerList)
		for i in range(playersLength) :
			print  i+1, printPlayerList[i]

		# user enters player number, causing the program to find that player
		# in wholeTable and print the rest of their statistics
		selectedPlayerNum = int(raw_input( "\nEnter the number of the player you" + " want: " ))
		selectedPlayerName = playerList[selectedPlayerNum-1]
		printSelectedPlayerName = printPlayerList[selectedPlayerNum-1]
		print printSelectedPlayerName, "\n"

		for i in range(teamLength) :
			if (wholeTable[selectedTeamName] [i] [0] == selectedPlayerName) :
				stats = wholeTable[selectedTeamName][i]
		print "Position:", stats[2]
		print "At Bats:", stats[3]
		print "Base Hits:", stats[4]
		print "Doubles:", stats[5]
		print "Triples:", stats[6]
		print "Home Runs:", stats[7]
		print "RBIs:", stats[8]
		print "Batting Average:", stats[9]

		# this line just waits for user input before looping to return to the
		# team menu
		menuReturn = int(raw_input( "\nEnter 99 to return to Teams list: "))

# CSC 207: The Sounds of Sorting REDO

Author: Finn Rowles

## REDO DETAILS:

Feedback receieved:
While your UI is renders with the bars, the sorting does not take place correctly. The bars are not in sorted order at the end of the sort. 
For an E, you need to 
1) fix your sorting such that the bars are sorted in the correct order.
2) fix your style violations (run "mvn checkstyle:check")

1) Done : my sorts are in correct order, highlighting and audio works as a bonus
2) running mvn checkstyle:check gives 0 checkstyle violations
mvn checkstyle:check
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------------< edu.grinnell.csc207:SortingVisualizer >----------------
[INFO] Building SortingVisualizer 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-checkstyle-plugin:3.6.0:check (default-cli) @ SortingVisualizer ---
[INFO] Starting audit...
Audit done.
[INFO] You have 0 Checkstyle violations.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.110 s
[INFO] Finished at: 2025-04-30T19:28:58-05:00
[INFO] ------------------------------------------------------------------------
rowlesfi@forsythe:the-sounds-of-sorting-1$ mvn checkstyle:check
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------------< edu.grinnell.csc207:SortingVisualizer >----------------
[INFO] Building SortingVisualizer 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-checkstyle-plugin:3.6.0:check (default-cli) @ SortingVisualizer ---
[INFO] Starting audit...
Audit done.
[INFO] You have 0 Checkstyle violations.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.895 s
[INFO] Finished at: 2025-04-30T19:40:30-05:00
[INFO] ------------------------------------------------------------------------

## Resources

*   Raymond Chu and Owen Block - worked on the sorting lab with these two.
*   Owen Block helped me further with quicksort and mergesort as well as do-while statements (on the lab mainly)
*   Colton Benson helped me understand the directions for PT3
*   Wikipedia for cocktail shaker sort
*   Fisher-Yates shuffle algorithm (from project 3)
*   Graphics and Color Java Libraries (Oracle)
*   Java Version 21.0.6
*   Visual Studio Code
*   Professor Osera's Lab Instructions
*   Owen Block to help me better understand highlighting at a high level

## Git Commits

* Some more touches to part 3 : 667bd44bcb799ef14c4fafa5c9cb27129f071e83
* Attempted to implement part 3, most work done in ArrayPanel. : d5620b6bac104d4710d8c67a81b95f44d29b0b29

* Yay : 05bc360a3cc373d30d30f994ae11824a9485715d
* more updates, part 2 : 1ae44a6cb1a9148ad16217eabc7395e2c7a47140

* more updates, started part 2, wrote tests, : 9a045100dd2c60f61f62ef604dc92ceedfd78157
* Implemented some sorting methods : 90e015a5a7495c654ba211814fed6a4baf05868a

commit 0450d4d528ae0fd5911a55839e17b28d76ae573f (HEAD -> main, origin/main, origin/HEAD)
Author: finn-rules <finn.rowles@gmail.com>
Date:   Wed Apr 30 19:36:35 2025 -0500

    Finish the project

commit 012f801b138694d15808e7bbed50a8b9469bfff2
Author: finn-rules <finn.rowles@gmail.com>
Date:   Wed Apr 30 12:45:49 2025 -0500

    Fixed highlight/sound, proper order of sorting

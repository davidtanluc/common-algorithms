Data cleaning and word count of a simple passage.
Below is an example of what your program would compute for the paragraph above. (The particular formatting below isn't required, as long as you output the word, number of occurrences, and list of sentence numbers.)
 
 
      a            {6:0,0,0,1,1,1}      of           {6:0,0,0,1,1,2}
      alphabetical {1:0}                often        {1:0}
      an           {2:0,1}              only         {1:3}
      and          {4:0,1,2,3}          or           {1:1}
      appears      {2:0,0}              output       {1:1}
      arbitrary    {1:1}                page         {1:0}
      assume       {1:3}                present      {1:0}
      ....
      ....
      occurs       {1:2}
      
  * to run 
      
       sbt clean compile run
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package school;
public class Teacher extends Person{
    private double meanLevel;
    private Course courses[] = new Course[Course.numPeriods];
    
    public static Teacher addTeacher(String _name,
    Gender _gender, int _weight,double _meanLevel)
    {
        Teacher temp = new Teacher(_name,_gender,_weight,
        _meanLevel);
        addPerson(temp);
        return(temp);
    }    
    Teacher (String _name,Gender _gender,int _weight,
    double _meanLevel)
    {
        super(_name,_gender,_weight);
        meanLevel = _meanLevel;
    }

    public boolean addCourse(Course _course)
    {
        if (!setCourseOK(_course))
            return(false);
        if (!_course.setTeacherOK(this))
            return(false);
        _course.setTeacherDoIt(this);
        setCourseDoIt(_course);
        return(true);
    } 
    public void setCourseDoIt(Course _course)
    {
        courses[_course.getPeriod()] = _course;
    }
    
    public boolean setCourseOK(Course _course)
    {
        if (_course == null)
            return(false);        
        if (courses[_course.getPeriod()] != null)
            return(false);
        return(true);
    }
    public void setMeanLevel(int _meanLevel)
    {
        meanLevel = _meanLevel;
    }
    public double getMeanLevel()
    {
        return(meanLevel);
    }        
    public static void printNames()
    {
        System.out.println(
        "===printNamesOf=== ");
        for (Person temp : people)
        {
            if (temp instanceof Teacher)
                System.out.println(temp.getName());
        }
    }
    
    public static Teacher mostElectiveCourses()
    {
        Teacher teacher = null;
        int numCurrElectives = 0;
        for(Person temp : people)
        {
            if(temp instanceof Teacher)
            {
                int numElective = 0;
                for(Course course : ((Teacher)temp).courses)
                {
                    if(course != null && course.getType() == Course.Type.Elective)
                    {
                        numElective++;
                    }
                }
                if(numElective > numCurrElectives)
                {
                    numCurrElectives = numElective;
                    teacher = (Teacher)temp;
                }
            }
        }
        return(teacher);
    }
    
    public static void printTeachersOfGrade(int _gradeLevel)
    {
        System.out.println(
        "Teachers that teach grade are " + _gradeLevel);
        for(Person temp : people)
        {
            if(temp instanceof Teacher)
            {
                boolean studentInGrade = false;
                for(Course course : ((Teacher)temp).courses)
                {
                    if(course != null)
                    {
                        for(int index = 0;index < course.getNumStudents();index++)
                        {
                           if(course.getStudent(index).getGradeLevel() == _gradeLevel)
                           {
                               studentInGrade = true;
                           }
                        }
                        
                    }

                }
                if(studentInGrade)
                {
                     System.out.println(temp.getName());
                }
            }
        }
    }
    
    public void printStudentsNames()
    {
       System.out.println(getName() + " teaches");
        for (Course temp : courses)
        {
            if (temp != null)
            {
                for (int index = 0;index < temp.getNumStudents();index++)
                {
                    System.out.println(temp.getStudent(index).getName());
                }
            }
        }
    }
    
    public void printStudentsNamesInGrade(int _gradeLevel)
    {
        System.out.println(
        "Students in grade " + _gradeLevel);
        for (Course temp : courses)
        {
            if (temp != null)
            {
                for (int index = 0;index < temp.getNumStudents();index++)
                {
                    if(temp.getStudent(index).getGradeLevel() == _gradeLevel)
                    System.out.println(temp.getStudent(index).getName());
                }
            }
        }
             
    }
}

# Java: Comparable vs. Comparator

In Java, when you want to sort a collection of objects, you need a way to define the ordering logic. Java provides two interfaces for this: `Comparable` and `Comparator`.

---

## 📊 Comparison Table

| Feature | Comparable | Comparator |
| :--- | :--- | :--- |
| **Sorting Sequence** | Provides a **single** (natural) sorting sequence. | Provides **multiple** sorting sequences. |
| **Modification** | **Modifies** the original class (implements interface). | **Does not modify** the original class. |
| **Method** | `compareTo(Object obj)` | `compare(Object obj1, Object obj2)` |
| **Package** | `java.lang` | `java.util` |
| **Usage** | `Collections.sort(List)` | `Collections.sort(List, Comparator)` |

---

## 💻 Code Examples

### 1. Comparable (Natural Ordering)
Used when there is one obvious way to sort a class. In this project (`ComparableExample.java`), the `Employee` class implements `Comparable` to sort by ID in **ascending** order.

```java
class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private int age;

    // ... constructors ...

    /*
        e1.compareTo(e2)
        Returns +ve => e1 > e2
        Returns 0   => e1 == e2
        Returns -ve => e1 < e2
     */
    @Override
    public int compareTo(Employee o) {
        if(this.id == o.id){
            return 0;
        }else if(this.id > o.id){
            return 1;
        }else{
            return -1;
        }
    }
}

// Usage
List<Employee> employeeList = new Employee().getEmployeeList();
Collections.sort(employeeList); // Uses compareTo
```

---

## 2. Comparator (Custom/Multiple Ordering)

The **Comparator** interface is used when you want to define custom sorting logic without modifying the source code of the original class. In this project (`ComparatorExample.java`), we sort `Student` objects by ID in **descending** order using a lambda expression.

```java
class Student {
    private int id;
    private String name;
    private int age;
    
    // ... constructors and getters ...
}

// Usage
List<Student> studentList = new Student().getStudentList();

/*
    Comparator logic:
    Returns +ve => a comes after b
    Returns -ve => a comes before b
    
    Here, if a.id < b.id, we return 1, meaning 'a' is considered 'greater' 
    than 'b' in this sort order, so it comes after.
    This results in Descending Order.
 */
Collections.sort(studentList, (a, b) -> {
    if(a.getId() == b.getId()){
        return 0;
    }else if(a.getId() < b.getId()){
        return 1;
    }else{
        return -1;
    }
});
```

---

## 3. Comparable and Comparator Together

You can use both interfaces. If a class implements `Comparable` (defining a natural order), you can still pass a `Comparator` to `Collections.sort()` to override that natural order with a custom order.

In `ComparableAndComparator.java`, the `Employer` class implements `Comparable` (sorting by ID ascending), but we pass a `Comparator` to sort by ID descending.

```java
// Employer implements Comparable (Ascending ID)
class Employer implements Comparable<Employer> {
    // ...
    @Override
    public int compareTo(Employer o) {
        if(this.id == o.id){
            return 0;
        }else if(this.id > o.id){
            return 1;
        }else{
            return -1;
        }
    }
}

// Usage
List<Employer> employerList = new Employer().getEmployerList();

// Even though Employer has a natural order, this Comparator takes precedence.
// Custom Order: Descending
Collections.sort(employerList, (a, b) -> {
    if(a.getId() == b.getId()){
        return 0;
    }else if(a.getId() < b.getId()){
        return 1;
    }else{
        return -1;
    }
});
```

---

## ❓ Common Interview Questions

**Q1: When should I use Comparable over Comparator?**
A: Use Comparable if you want to define the default (natural) sorting for a class. Use Comparator if you need to sort objects in different ways (e.g., by name, then by age) or if you don't have access to modify the source code of the class you are sorting.

**Q2: Can a class implement both?**
A: Yes. A class can have a natural order (Comparable) and still be sorted using various custom rules (Comparators). The Comparator passed to the sort method will always take precedence over the Comparable implementation.

**Q3: What does the return value of compare() or compareTo() mean?**
A:
*   **Negative Integer**: The first object is "less than" the second.
*   **Zero**: Both objects are equal.
*   **Positive Integer**: The first object is "greater than" the second.

**Q4: Which one is better for "Open-Closed Principle"?**
A: Comparator is better. It follows the Open-Closed Principle because you can add new sorting logic by creating new Comparator classes without modifying the existing code of the data class.

**Q5: Can we use Lambda expressions with these?**
A: Yes, since Java 8, Comparator is a functional interface. You can write:
`Collections.sort(list, (s1, s2) -> s1.getName().compareTo(s2.getName()));`

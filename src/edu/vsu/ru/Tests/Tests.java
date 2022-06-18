package ru.vsu.cs.course1.tests;

import edu.vsu.ru.ArrayHandler;
import edu.vsu.ru.util.ListUtils;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public final class Tests {

    @Parameterized.Parameter
    public @NotNull TestCase testCase;

    @Parameterized.Parameters
    public static @NotNull
    Collection<TestCase> data(){
        List<TestCase> resList = Arrays.asList(
                new TestCase (new int[] {4, 5, 3, 6, 9, 1, 8}, 9, "4  3  1  "),
                new TestCase (new int[] {1, 2, 3, 6, 7, 3, 5, 6, 7, 2}, 5, "2  "),
                new TestCase (new int[] {1, 2, 3, 4, 5}, 1,"")
        );
        return resList;
    }

    public static final class TestCase {
        public final int[] srcArray;
        public final int sum;
        public final String resultStrOneElementOfPair;

        public TestCase(int[] srcArray, int S, String resultStrOneElementOfPair) {
            this.srcArray = srcArray;
            this.sum = S;
            this.resultStrOneElementOfPair = resultStrOneElementOfPair;
        }
    }

    @Test
    public void test() {
        List<Integer> testResultIntList = ArrayHandler.findPairs(testCase.srcArray, testCase.sum);
        List<String> testResultStrList = ListUtils.intListToStringList(testResultIntList);
        String testString = ListUtils.strListToStr(testResultStrList);
        Assert.assertEquals(testString, testCase.resultStrOneElementOfPair);
    }
}
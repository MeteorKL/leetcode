/*
 * @lc app=leetcode id=23 lang=c
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
#define DEBUG 1
#if 0
#define NULL (void *)0
struct ListNode
{
  int val;
  struct ListNode *next;
};
#endif

int finMin(struct ListNode **lists, int listsSize)
{
  int assignFlag = 0;
  int min;
  int index = -1;
  for (int i = 0; i < listsSize; i++)
  {
    if (lists[i] != NULL)
    {
      if (assignFlag == 0)
      {
        index = i;
        min = lists[i]->val;
        assignFlag = 1;
      }
      else if (lists[i]->val < min)
      {
        index = i;
        min = lists[i]->val;
      }
    }
  }
  return index;
}

struct ListNode *mergeKLists(struct ListNode **lists, int listsSize)
{
  struct ListNode *head = malloc(sizeof(struct ListNode));
  if (head == NULL)
  {
    return NULL;
  }
  head->next = NULL;
  head->val = 0;
  struct ListNode *p = head;
  while (1)
  {
    int i = finMin(lists, listsSize);
    if (i == -1)
    {
      break;
    }
    struct ListNode *temp = malloc(sizeof(struct ListNode));
    if (temp == NULL)
    {
      return NULL;
    }
    temp->next = NULL;
    temp->val = lists[i]->val;
    lists[i] = lists[i]->next;
    p->next = temp;
    p = temp;
  }
  struct ListNode *temp = head;
  head = head->next;
  free(temp);
  return head;
}

// @lc code=end
